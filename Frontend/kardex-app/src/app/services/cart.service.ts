import { CartItem } from './../models/cart-item';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {


  cartItems: CartItem[] = [];
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);
  totalQuantity: Subject<number> = new BehaviorSubject<number>(0);

  constructor() { }

  addToCart(theCartItem: CartItem){

    let alreadyExistInCart: boolean = false;
    let existingCartItem: CartItem = undefined;

    if(this.cartItems.length > 0){

          existingCartItem = this.cartItems.find(tempCartItem => tempCartItem.id === theCartItem.id);

          alreadyExistInCart = (existingCartItem != undefined);
    }

    if(alreadyExistInCart){
      existingCartItem.quantity++;
    }else{
      this.cartItems.push(theCartItem);
    }


    this.computeCartTotals();


  }
  computeCartTotals() {
    let totalPriceValue: number =0;
    let totalQuantityValue: number =0;

    for(let tempCartItem of this.cartItems){
      totalPriceValue += tempCartItem.quantity * tempCartItem.unitPrice;
      totalQuantityValue += tempCartItem.quantity;
    }

    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);

    this.logCartData( totalPriceValue , totalQuantityValue);
  }


  logCartData(totalPriceValue: number, totalQuantityValue: number) {
    console.log('-----------Contenido del carro--------')
    for(let tempCartItem of this.cartItems){
      let subTotalPrice = tempCartItem.unitPrice * tempCartItem.quantity;
      console.log(`Name: ${tempCartItem.name}, quantity: ${tempCartItem.quantity}, price: ${tempCartItem.unitPrice}, subTotalPrice: ${subTotalPrice} `);
      console.log(`totalPrice: ${totalPriceValue}, totalQuantity: ${totalQuantityValue}`);
    }
  }


  decrementQuantity(theCartItem: CartItem) {
     theCartItem.quantity--;
     if(theCartItem.quantity == 0){
       this.removeCartItem(theCartItem);
     }else{
       this.computeCartTotals();
     }
  }

  removeCartItem(theCartItem: CartItem) {
    const itemIndex = this.cartItems.findIndex(tempCartItem => tempCartItem.id == theCartItem.id);
    if(itemIndex > -1){
      this.cartItems.splice(itemIndex, 1);
      this.computeCartTotals();
    }

  }


}

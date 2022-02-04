import { Purchase } from './../models/purchase';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {  map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  private purchaseUrl: string = "http://localhost:8084/kardex-api/shopping-kardex-hulk-store/v1.0.0/shopping-create/create";

  constructor(private http: HttpClient) { }

  placeOrder(purchase: Purchase): Observable<any> {
    return this.http.post<GetResponsePurchase>(this.purchaseUrl, purchase);
  }

}

interface GetResponsePurchase{
      orderTrackingNumber: string;
}

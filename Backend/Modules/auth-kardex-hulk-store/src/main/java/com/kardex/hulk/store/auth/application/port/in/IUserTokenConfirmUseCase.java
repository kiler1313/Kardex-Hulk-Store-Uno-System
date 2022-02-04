package com.kardex.hulk.store.auth.application.port.in;

import java.util.Map;

public interface IUserTokenConfirmUseCase {

    Boolean tokenConfirm(String token);
}

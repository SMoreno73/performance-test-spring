package com.riwi.test.infraestructure.abstract_services;

import com.riwi.test.api.dto.request.UserRequest;
import com.riwi.test.api.dto.response.UserResponse;

public interface IUserService extends
        CreateReadService<UserRequest, UserResponse, Long>,
        UpdateService<UserRequest, UserResponse, Long>
{
}

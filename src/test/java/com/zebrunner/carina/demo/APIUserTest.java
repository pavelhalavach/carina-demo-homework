/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo;

import com.zebrunner.carina.demo.api.user.*;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

import static org.testng.AssertJUnit.assertEquals;

public class APIUserTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "pavel")
    @TestPriority(Priority.P1)
    public void testCreateUser() {
        PostUserMethod api = new PostUserMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "pavel")
    public void testGetUsers() {
        GetUsersMethod api = new GetUsersMethod();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/users/_get/rs.schema");

        assertEquals(10, api.callAPI().jsonPath().getList("$").size());
    }

    @Test()
    @MethodOwner(owner = "pavel")
    @TestPriority(Priority.P2)
    public void testDeleteUser() {
        DeleteUserMethod api = new DeleteUserMethod();
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "pavel")
    public void testGetUser() {
        GetUserMethod api = new GetUserMethod();
        api.callAPIExpectSuccess();

        assertEquals(2, api.callAPI().jsonPath().getInt(("id")));
    }

    @Test()
    @MethodOwner(owner = "pavel")
    public void testPutUser() {
        PutUserMethod api = new PutUserMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

}

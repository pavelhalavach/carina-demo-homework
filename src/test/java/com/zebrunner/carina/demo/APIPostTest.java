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

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.demo.api.post.*;

import org.testng.annotations.Test;

public class APIPostTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "pavel")
    @TestPriority(Priority.P1)
    public void testCreatePost() {
        PostPostMethod api = new PostPostMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "pavel")
    public void testGetPosts() {
        GetPostsMethod api = new GetPostsMethod();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/posts/_get/rs.schema");
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "pavel")
    public void testGetPost() {
        GetPostMethod api = new GetPostMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "pavel")
    @TestPriority(Priority.P2)
    public void testDeletePost() {
        DeletePostMethod api = new DeletePostMethod();
        api.setProperties("api/posts/post.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "pavel")
    public void testPutPost() {
        testCreatePost();
        PutPostMethod api = new PutPostMethod();
        api.setProperties("api/posts/postPut.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
        DeletePostMethod apiDelete = new DeletePostMethod();
        apiDelete.setProperties("api/posts/postPut.properties");
        apiDelete.callAPIExpectSuccess();
        apiDelete.validateResponse();
    }
}

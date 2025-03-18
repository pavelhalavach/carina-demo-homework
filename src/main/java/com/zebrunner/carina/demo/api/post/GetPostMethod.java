package com.zebrunner.carina.demo.api.post;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/posts/2", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/posts/_get/rsGetPost.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPostMethod extends AbstractApiMethodV2 {
    public GetPostMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }

}

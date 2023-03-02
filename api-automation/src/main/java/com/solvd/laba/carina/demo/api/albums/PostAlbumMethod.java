package com.solvd.laba.carina.demo.api.albums;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.api_url}/albums", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/albums/_post/rq.json")
@ResponseTemplatePath(path = "api/albums/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
@PropertiesPath(path = "api/albums/albums.properties")
public class PostAlbumMethod extends AbstractApiMethodV2 {
    public PostAlbumMethod() {

    }
}
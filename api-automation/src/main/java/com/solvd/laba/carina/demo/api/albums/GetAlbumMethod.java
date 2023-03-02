package com.solvd.laba.carina.demo.api.albums;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;


@Endpoint(url = "${config.env.api_url}/albums", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/albums/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetAlbumMethod extends AbstractApiMethodV2 {
    public GetAlbumMethod() {

    }
}

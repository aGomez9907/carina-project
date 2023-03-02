package com.solvd.laba.carina.demo.api.albums;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.api_url}/albums/${id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/albums/_patch/rq.json")
@ResponseTemplatePath(path = "api/albums/_patch/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchAlbumMethod extends AbstractApiMethodV2 {
    public PatchAlbumMethod() {
    }
}

package com.solvd.laba.carina.homework.api.albums;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class ApiTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiTest.class);


    @Test()
    @MethodOwner(owner = "agomez")
    public void testGetAlbums() {
        GetAlbumMethod api = new GetAlbumMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/albums/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "agomez")
    public void testCreateAlbum() {
        LOGGER.info("test post");

        PostAlbumMethod api = new PostAlbumMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "agomez")
    public void testCreateAlbumWithMissingFields() {
        LOGGER.info("test post w/ missing fields");

        PostAlbumMethod api = new PostAlbumMethod();
        api.getProperties().remove("id");
        api.callAPI();
        api.validateResponse();
    }


    @Test
    public void testUpdateAlbum() {
        LOGGER.info("test patch");

        PostAlbumMethod api = new PostAlbumMethod();
        Response response = api.callAPIExpectSuccess();
        api.validateResponse();

        PatchAlbumMethod patchAlbumMethod = new PatchAlbumMethod();
        patchAlbumMethod.replaceUrlPlaceholder("id", Integer.toString(response.jsonPath().getInt("id")));
        patchAlbumMethod.callAPIExpectSuccess();
        api.validateResponse();
    }

}

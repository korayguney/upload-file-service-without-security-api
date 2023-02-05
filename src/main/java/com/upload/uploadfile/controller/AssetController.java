package com.upload.uploadfile.controller;

import com.upload.uploadfile.model.Asset;
import com.upload.uploadfile.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AssetController {

    private final AssetService service;

    @PostMapping("/asset")
    public Asset saveAssetType(@RequestBody Asset asset) {
        return service.saveAsset(asset);
    }
}

package com.upload.uploadfile.controller;

import com.upload.uploadfile.model.AssetType;
import com.upload.uploadfile.service.AssetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AssetTypeController {

    private final AssetTypeService service;

    @PostMapping("/assettype")
    public AssetType saveAssetType(@RequestBody AssetType assetType) {
        return service.saveAssetType(assetType);
    }
}

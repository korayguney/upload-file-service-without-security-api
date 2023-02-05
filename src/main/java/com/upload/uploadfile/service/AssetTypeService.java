package com.upload.uploadfile.service;

import com.upload.uploadfile.model.AssetType;
import com.upload.uploadfile.repository.AssetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetTypeService {
    private final AssetTypeRepository repository;

    public AssetType saveAssetType(AssetType assetType) {
        return repository.save(assetType);
    }
}

package com.upload.uploadfile.service;

import com.upload.uploadfile.model.Asset;
import com.upload.uploadfile.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetService {
    private final AssetRepository repository;

    public Asset saveAsset(Asset asset) {
        return repository.save(asset);
    }
}

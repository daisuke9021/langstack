package jp.langstack.infra.s3;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class S3Service {

    private final S3Repository s3Repo;

    // TODO：プロパティファイル外だし
    private String bucketName = "langstack-bucket";

    public void uploadObjectIfNotExists(String objectKey, String base64Str) {
        createBucketIfNotExists(bucketName);
        if(s3Repo.getObject(objectKey, bucketName).isEmpty()) {
            s3Repo.addObject(objectKey, bucketName, base64Str);
        }
    }

    public void deleteObjectIfExists(String objectKey) {
        if(s3Repo.getObject(objectKey, bucketName).isPresent()) {
            s3Repo.deleteObject(objectKey, bucketName);
        }
    }

    private void createBucketIfNotExists(String bucketName) {
        if(s3Repo.getBucket(bucketName).isEmpty()) {
            s3Repo.createBucket(bucketName);
        }
    }
    
}

package test.database.service;

public interface UploadService {

    /**
     * 上传一张图片
     * @param id
     * @param flag
     * @param url
     * @return
     */
    String uploadPicture(int id,int flag,String url);

    /**
     * 点赞
     * @param pId
     */
    void uploadPraise(int pId);

    /**
     *发布公告
     * @param aId
     * @param content
     */
    void uploadNotice(int aId, String content);
}

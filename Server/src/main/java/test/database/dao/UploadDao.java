package test.database.dao;

public interface UploadDao {

    /**
     * 向数据库中添加一张图片链接
     * @param id
     * @param flag
     * @param url
     */
    void addPicture(int id,int flag,String url);

    /**
     * 点赞
     * @param pId
     */
    void addPraise(int pId);

    /**
     * 更新图片
     * @param id
     * @param flag
     * @param url
     */
    void update(int id, int flag, String url);

    /**
     * 发布公告
     * @param aId
     * @param content
     */
    void updateNotice(int aId, String content);
}

package test.database.service.Impl;

import test.database.dao.Impl.UploadDaoImpl;
import test.database.dao.UploadDao;
import test.database.service.UploadService;

public class UploadServiceImpl implements UploadService {

    private UploadDao uploadDao = new UploadDaoImpl();
    private final String pathFirst = "http://192.168.1.237:8080/test/images/";


    @Override
    public String uploadPicture(int id, int flag, String url) {
        if(flag == 0){
            uploadDao.update(id,flag,url);
        }else{
            uploadDao.addPicture(id,flag,url);
        }
        return pathFirst + url;

    }

    @Override
    public void uploadPraise(int pId) {
        uploadDao.addPraise(pId);
    }

    @Override
    public void uploadNotice(int aId, String content) {
        uploadDao.updateNotice(aId,content);
    }
}

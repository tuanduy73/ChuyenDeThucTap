package Service;

import QuanLi.GameDao;
import Table.Gaming;
import java.util.List;

public class GamingService {
private QuanLi.GameDao gameDao;
    
    public GamingService()
    {
        gameDao = new GameDao();
    }
    public List<Gaming> getAllGaming()
    {
        return gameDao.getAllGaming();
    }
    public void addGaming(Gaming gaming)
    {
        gameDao.addGaming(gaming);
    }
    public void deleteGaming (String TenSanPham)
    {
        gameDao.deletaGaming(TenSanPham);
    }
    public Gaming getGamingByName (String TENSANPHAM)
    {
        return gameDao.getGamingByName(TENSANPHAM);
    }
    public void updateGaming(Gaming gaming)
    {
        gameDao.updateGaming(gaming);
    }	
}

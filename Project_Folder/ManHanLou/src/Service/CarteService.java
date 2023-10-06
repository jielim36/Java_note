package Service;

import DAO.CarteDAO;
import Domain.Carte;

import java.util.List;

/**
 * 该类是针对点餐的各种服务
 * 比如：显示所有菜品，点餐服务
 */
public class CarteService {

    private CarteDAO carteDAO = new CarteDAO();

    //该方法用于返回菜单的所有菜品信息
    public List<Carte> getCarte(){ //返回一个list
        return carteDAO.queryMulti(Carte.class , "select * from carte");
    }



    //该方法输入菜品id后返回对应的菜品信息
    public Carte getFoodById(int id){
        return carteDAO.querySingle(Carte.class , "select * from carte where id = ?" ,id);
    }

}

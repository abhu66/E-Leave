/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleave.dao;

import eleave.daoImpl.KategoriCutiDaoImpl;

/**
 *
 * @author khoerulAbu
 */
public class DaoImplFactory  implements  DaoFactory{
    @Override
    public KategoriCutiDao getKatgoryCutiDao() {return new KategoriCutiDaoImpl();}
   
}

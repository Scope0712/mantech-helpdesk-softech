/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbSolutions;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbSolutionsFacadeLocal {

    void create(TbSolutions tbSolutions);

    void edit(TbSolutions tbSolutions);

    void remove(TbSolutions tbSolutions);

    TbSolutions find(Object id);

    List<TbSolutions> findAll();

    List<TbSolutions> findRange(int[] range);

    int count();

    List<TbSolutions> findAllSolutions();

    List<TbSolutions> searchListSolutions(String search);
}

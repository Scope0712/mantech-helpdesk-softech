/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entity.TbDepartments;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import sessionbean.TbDepartmentsFacadeLocal;


/**
 *
 * @author tuyenbui
 */
public class TDepartmentMB {
    @EJB
    private TbDepartmentsFacadeLocal tbDepartmentsFacade;
    
    //list to bind to datatable
    private static List<Department> deptList ;
    
    //new department to be added to the list
    private TbDepartments newDept;

    /** Creates a new instance of TDepartmentMB */
    public TDepartmentMB() {
        newDept = new TbDepartments();
    }

    public List<Department> getDeptList() {
         List<TbDepartments> list = tbDepartmentsFacade.findAll();
        if (deptList == null)deptList = new ArrayList<Department>();
        if (deptList.isEmpty()) {
            for (TbDepartments tbDept : list) {
                deptList.add(new Department(tbDept));
            }
        }
        return deptList;
    }

    public TbDepartments getNewDept() {
        return newDept;
    }

    public void setNewDept(TbDepartments newDept) {
        this.newDept = newDept;
    }

    public String editAction(Department dept){
        dept.editable = true;
        return null;
    }

    public String saveAciton(){
        for (Department dept:deptList){
            //set uneditable
            dept.editable = false;
            //apply change to db
            tbDepartmentsFacade.edit(dept.tbDept);
        }
        return null;
    }

    public String addAction(){
        //create new department in db
        tbDepartmentsFacade.create(newDept);
        //add to list for display
        deptList.add(new Department(newDept));
        return null;
    }

    public static class Department{
        TbDepartments tbDept;
        boolean editable;

        public Department(TbDepartments tbDept){
            this.tbDept = tbDept;
        }
        public boolean isEditable() {
            return editable;
        }

        public void setEditable(boolean editable) {
            this.editable = editable;
        }

        public TbDepartments getTbDept() {
            return tbDept;
        }

        public void setTbDept(TbDepartments tbDept) {
            this.tbDept = tbDept;
        }

    }

}

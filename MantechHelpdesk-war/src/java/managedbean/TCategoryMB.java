/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbCategories;
import java.util.List;
import java.util.Vector;
import javax.ejb.EJB;
import sessionbean.TbCategoriesFacadeLocal;

/**
 *
 * @author tuyenbui
 */
public class TCategoryMB {

    @EJB
    private TbCategoriesFacadeLocal tbCategoriesFacade;
    private static List<Category> categoryList; //ko phai static se ko luu gia tri edit
    private TbCategories newcategory; //new category will be added to the list

    /** Creates a new instance of TCategoryMB */
    public TCategoryMB() {
        newcategory = new TbCategories();

    }

    public TbCategories getCategory() {
        return newcategory;
    }

    public void setCategory(TbCategories category) {
        this.newcategory = category;
    }

    public List<Category> getCategoryList() {
       List<TbCategories> list = tbCategoriesFacade.findAll();
        if (categoryList == null)categoryList = new Vector<Category>();
        if (categoryList.isEmpty()) {
            for (TbCategories c : list) {
                categoryList.add(new Category(c));
            }
        }
        return categoryList;
    }

    public TbCategories findCategory(String categoryId) {
        return tbCategoriesFacade.find(categoryId);
    }

    public String saveAction() {
        System.out.println("goi saveAction");
        for (Category c : categoryList) {
            c.setEditable(false);
            System.out.println("category: id " + c.category.getCategoryId() + " Name:" + c.category.getCategoryName() + " priority:" + c.category.getPriority());
            tbCategoriesFacade.edit(c.category);
        }
        //return current page
        return null;
    }

    public String editAction(Category category) {
        category.setEditable(true);
        //return current page
        return null;
    }

    public String addAction() {
        //newcategory = new TbCategories();
        //newcategory.setCategoryId("");
        System.out.println("Add category: ID= " + newcategory.getCategoryId() + " Name= " + newcategory.getCategoryName() + " Priority=" + newcategory.getPriority());
        //save to db
        tbCategoriesFacade.create(newcategory);
        //add to display list
        categoryList.add(new Category(newcategory));
        return null;
    }

    public static class Category {

        TbCategories category;
        boolean editable;

        public Category(TbCategories category) {
            this.category = category;
        }

        public TbCategories getCategory() {
            return category;
        }

        public void setCategory(TbCategories category) {
            this.category = category;
        }

        public boolean isEditable() {
            return editable;
        }

        public void setEditable(boolean editable) {
            this.editable = editable;
        }
    }
}

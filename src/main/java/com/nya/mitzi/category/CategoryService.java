package com.nya.mitzi.category;

import com.nya.mitzi.enum1.ErrorMessage;
import com.nya.mitzi.exception.CategoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category addCategory(Category category)throws CategoryException {
        /*
        errors:
            1.name
                1.null
                2.empty
                3.not unique
        */
        //1.1, 1.2
        if(category.getName()==null|| category.getName().isEmpty()){
            throw new CategoryException(ErrorMessage.NAME_MISSING);
        }
        //1.3
        if(this.categoryRepo.existsByName(category.getName())){
            throw new CategoryException(ErrorMessage.NAME_EXIST);
        }
        System.out.println("category added"+'\n');
        return this.categoryRepo.save(category);
    }

    public void updateCategory(int id, Category category) throws CategoryException {
              /*
        errors:
            1.id not exist
            2.name
                1.null
                2.empty
                3.name not unique, id different from "other category with name"
        */
        //1.
        if (!this.categoryRepo.existsById(id)) {
            throw new CategoryException(ErrorMessage.ID_NOT_EXIST);
            //System.out.println("id not exist"+'\n');
            //return;
        }
        category.setId(id);
        //2.1, 2.2
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new CategoryException(ErrorMessage.NAME_MISSING);
        }
        //3.3
        if(this.categoryRepo.existsByName(category.getName())){
            this.isUniqueByName(category);
        }
        System.out.println("category updated"+'\n');
        this.categoryRepo.save(category);
    }

    public void deleteCategory(int id) throws CategoryException {
                      /*
        errors:
            1.id not exist
        */
        //1.
        if(!this.categoryRepo.existsById(id)) {
            throw new CategoryException(ErrorMessage.ID_NOT_EXIST);//todo fix
        }
        System.out.println("category deleted"+'\n');
        this.categoryRepo.deleteById(id);
    }

    public Category getCategory(int id) throws CategoryException {
        /*
        errors:
            1.id not exist
        */
        //1.
        return this.categoryRepo.findById(id).orElseThrow(()->new CategoryException
                (ErrorMessage.ID_NOT_EXIST));
    }

    public List<Category> getCategoryList(){
        return this.categoryRepo.findAll();
    }

    //////
    //used in update func
    public void isUniqueByName(Category category) throws CategoryException {
        Category category1 = this.categoryRepo.findByName(category.getName()).
                orElseThrow(() -> new CategoryException(ErrorMessage.ID_NOT_EXIST));
        System.out.println();
        if(category.getId() != category1.getId()){
            throw new CategoryException(ErrorMessage.NAME_EXIST);
        }
    }


}

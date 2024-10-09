package com.nya.mitzi.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories")
public class CategoyController {

    @Autowired
    private CategoryService categoryService;


/*    @PostMapping
    public Category addCategory(@RequestBody Category category) throws CategoryException {
            return this.categoryService.addCategory(category);
    }

    @GetMapping("{id}")
    public Object getCategoy(@PathVariable int id){
        try {
            return this.categoryService.getCategory(id);
        } catch (CategoryException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/filter")
    public Object getCategoyByName(String name) throws CategoryException {
            return this.categoryService.getCategoryByName(name);
    }

    @GetMapping
    public List<Category>getCategoryList(){
        return this.categoryService.getCategoryList();
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable int id) throws CategoryException {
        this.categoryService.deleteCategory(id);
    }*/

}

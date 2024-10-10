type CategoryConstructorArgs = {
  //?
  name: string;
  id: number;
};

class Category {
  //defines class and its properties
  public readonly id: number;
  public name: string;

  constructor(args: CategoryConstructorArgs) {
    //constructor
    this.name = args.name;
    this.id = args.id;
  }
}

export default Category;

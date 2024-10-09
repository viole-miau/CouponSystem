type CategoryConstructorArgs = {
  name: string;
  id: number;
};

class Category {
  public readonly id: number;
  public name: string;

  constructor(args: CategoryConstructorArgs) {
    this.name = args.name;
    this.id = args.id;
  }
}

export default Category;

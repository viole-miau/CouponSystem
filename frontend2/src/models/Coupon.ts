import Category from "./Category";
import Company from "./Company";

type CouponConstractorArguments = {
  id?: number;
  title: string;
  description: string;
  amount: number;
  price: number;
  startDate: Date;
  endDate: Date;
  company?: Company;
  category?: Category;
};

class Coupon {
  public readonly id?: number;
  public title: string;
  public description: string;
  public amount: number;
  public price: number;
  public startDate: Date;
  public endDate: Date;
  public company?: Company;
  public category?: Category;

  constructor(args: CouponConstractorArguments) {
    this.title = args.title;
    this.description = args.description;
    this.startDate = args.startDate;
    this.endDate = args.endDate;
    this.amount = args.amount;
    this.price = args.price;
    this.company = args.company;
    this.category = args.category;
  }
}
export default Coupon;

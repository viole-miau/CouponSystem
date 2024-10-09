import Coupon from "./Coupon";
import Customer from "./Customer";

type CouponConstractorArguments = {
  id?: number;
  coupon: Coupon;
  customer: Customer;
};

class CouponCustomer {
  public readonly id?: number;
  public coupon: Coupon;
  public customer: Customer;

  constructor(args: CouponConstractorArguments) {
    this.coupon = args.coupon;
    this.customer = args.customer;
  }

  get couponName(): string {
    return this.coupon.title;
  }

  get customerName(): string {
    return this.customer.fullName;
  }
}
export default CouponCustomer;

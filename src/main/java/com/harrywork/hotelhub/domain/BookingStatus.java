package com.harrywork.hotelhub.domain;

/**
 * General Process
 *
 *reference rules from
 *
 *<a href="http://www.hpjyl.com/help/20/"></a>
 *
 *
 * new order
 *
 * Indicates that just booked, if you want to cancel the order, you can log in to the User Member Center,
 * automatically cancel the order, complete the cancellation, if you cancel the order verbally,
 * please call the customer service hotline, we will handle it for you.
 *
 * Processing
 * Indicates that the staff of the website is processing
 *
 * Processed (to be stayed)
 *
 * Checked in (to be commented)
 *
 * Cancelled
 * Indicates that this order has been cancelled.
 *
 *
 *
 * @author Harry
 * @date 19-6-26
 * Time: 15:41
 * Desc: BookingStatus
 */
public enum BookingStatus {

    NewOrder("new"),

    Processing("processing"),

    Processed("processed"),

    CheckedIn("checked in"),

    Cancelled("cancelled");

    private String status;

    private BookingStatus(String status) {
        this.status = status;
    }
}

package com.testproject.swp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "service")
public class MyService {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,name = "service_id")
    private int id;

    @Column(name = "service_title")
    private String title;

    @Column(name = "service_bi")
    private String bi;

    @Column(name = "service_created_date")
    private String createddate;

    @Column(name = "category_id")
    private String categoryid;

    @Column(name = "service_price")
    private String price;

    @Column(name = "service_discount")
    private String discount;

    @Column(name = "service_detail")
    private String detail;

    @Column(name = "service_rateStar")
    private String rateStar;

    @Column(name = "service_vote")
    private String vote;


    @OneToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", insertable = false, updatable = false)
    private MyServiceImage myServiceImage;
    @Transient
    private String imagelink;


    @OneToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", insertable = false, updatable = false)
    private MyServiceStatus myServiceStatus;
    @Transient
    private int status;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    private MyServiceCategory serviceCategory;
    @Transient
    private String categoryname;


    @PostLoad
    private void onLoad() {
        if (myServiceImage != null) {
            imagelink = myServiceImage.getImagelink();
        }
        if (myServiceStatus != null) {
            status = myServiceStatus.getServicestatus();
        }
        if (serviceCategory != null) {
            categoryname = serviceCategory.getCategoryname();
        }
    }

}

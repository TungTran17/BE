package com.testproject.swp.entity;

import lombok.*;

import javax.persistence.*;

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
    @Column(unique = true, name = "service_id")
    private int id;

    @Column(unique = true, name = "service_title")
    private String title;

    @Column(unique = true, name = "service_bi")
    private String bi;

    @Column(unique = true, name = "service_created_date")
    private String createddate;

    @Column(unique = true, name = "category_id")
    private int categoryid;

    @Column(unique = true, name = "service_price")
    private String price;

    @Column(unique = true, name = "service_discount")
    private String discount;

    @Column(unique = true, name = "service_detail")
    private String detail;

    @Column(unique = true, name = "service_rateStar")
    private String rateStar;

    @Column(unique = true, name = "service_vote")
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

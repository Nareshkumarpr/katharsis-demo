package com.example.domain.model;

/**
 * @author 1388162
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiIncludeByDefault;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.JsonApiToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonApiResource(type = "customer")
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Customer implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @JsonApiId
    private Long id;

    @JsonProperty("name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customer_address", joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
    @JsonApiToMany
    @JsonApiIncludeByDefault
    @JsonProperty("address")
    private List<Address> address;

}
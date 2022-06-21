package com.example;


import com.example.User;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@RestController
@Path(("/user"))
public class ExampleResource {


    @POST
    @Transactional
    public Response adduser(User user)
    {

            User.persist(user);

         return Response.ok(user).status(200).build();

    }
//    @POST
//    @Transactional
//    @Path("/AddAddress")
//    public Response adduseraddress(Address address)
//    {
//
//        Address.persist(address);
//
//        return Response.ok(address).status(200).build();
//
//    }

    @GET
    @Path("/test")
    public String test()

    {
        return "hello world";
    }


    @GET
    public List<User> getall()

    {
        return User.listAll();
    }

//    @GET
//    @Path("/GetAddress")
//    public List<Address> getallAddress()
//
//    {
//        return Address.listAll();
//    }
    @PUT
    @Path("id/{id}/firstname/{firstname}")
    @Transactional
    public Response update_customerFirstName(@PathParam("id") Long id ,@PathParam("firstname") String firstname )

    {

//     Optional<User> enti=  User.findByIdOptional(id) ;


        User saveuser=User.findById(id) ;
             if(saveuser==null)
     {
        throw new WebApplicationException("user not found ");

     }
     saveuser.setFirstname(firstname);
        //saveuser.setFirstname(user.getFirstname());

       saveuser.persist();

     return Response.ok(saveuser).build();
    }


    @DELETE
    @Path("id/{id}")
    @Transactional
    public void delete_user(@PathParam("id") Long id)
    {
        Optional<User> user=User.findByIdOptional(id);

        user.get().delete();


    }


}

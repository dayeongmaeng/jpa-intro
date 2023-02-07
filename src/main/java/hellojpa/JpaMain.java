package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddreess(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("============= START =============");
            Member findMember = em.find(Member.class, member.getId( ));

//            Addreess a = findMember.getHomeAddreess();
//            findMember.setHomeAddreess(new Addreess("newCity", a.getStreet(), a.getZipcode()));
//
//            ///치킨 -> 한식 단순 스트링
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("샐러드");

//            //객체 수정
//            findMember.getAddressHistory().remove(new AddreessEntity("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new AddreessEntity("newCity1", "street", "10000"));

            tx.commit();

        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

        emf.close();
    }

}

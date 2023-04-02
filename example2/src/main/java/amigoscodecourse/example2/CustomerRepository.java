package amigoscodecourse.example2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> { //Integer porque el id de Customer es de tipo Integer
    
}

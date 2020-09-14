package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private Map<String, Owner> mapByLastName = new HashMap<>();
    @Override
    public Owner save(Owner owner) {
        map.put(owner.getId(), owner);
        mapByLastName.put(owner.getLastName(), owner);
        return owner;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return mapByLastName.get(lastName);
    }

//    @Override
//    public Set<Owner> findAll() {
//        return super.findAll();
//    }
//
//    @Override
//    public Owner findById(Long id) {
//        return super.findById(id);
//    }
//
//    @Override
//    public Owner save(Long id, Owner owner) {
//        return super.save(id, owner);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        super.deleteById(id);
//    }
//
//    @Override
//    public void delete(Owner owner) {
//        super.delete(owner);
//    }
}

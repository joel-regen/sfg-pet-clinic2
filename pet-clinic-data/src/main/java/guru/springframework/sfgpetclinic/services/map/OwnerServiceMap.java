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
        super.save(owner);
        mapByLastName.put(owner.getLastName(), owner);
        return owner;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return mapByLastName.get(lastName);
    }

}

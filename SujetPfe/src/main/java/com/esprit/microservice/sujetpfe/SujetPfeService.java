package com.esprit.microservice.sujetpfe;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class SujetPfeService  implements ISujetPfe{
    @Autowired
    private SujetPfeRepository sujetPfeRepository;

    @Override
    public SujetPfe ajouterSujet(SujetPfe sujetPfe) {
        return sujetPfeRepository.save(sujetPfe);
    }

    @Override
    public List<SujetPfe> getAllSujets() {
        return sujetPfeRepository.findAll();
    }

    @Override
    public SujetPfe getSujetById(Integer id) {
        return sujetPfeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sujet non trouvé"));
    }

    @Override
    public SujetPfe modifierSujet(Integer id, SujetPfe updatedSujet) {
        SujetPfe s = sujetPfeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sujet non trouvé"));
        updatedSujet.setId(s.getId()); // Ici, tu es sûr que s n'est pas null
        return sujetPfeRepository.save(updatedSujet);
    }

    @Override
    public void supprimerSujet(Integer id) {
        if (sujetPfeRepository.existsById(id)) {
            sujetPfeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Sujet non trouvé");
        }
    }
}

package com.pallin.clickbus;

import com.pallin.clickbus.controller.PlaceController;
import com.pallin.clickbus.model.Place;
import com.pallin.clickbus.repository.PlaceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class ClickbusApplicationTests {

    @InjectMocks
    private PlaceController placeController;

    @Mock
    private PlaceRepository placeRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test getting an specific place by ID
     */
    @Test
    public void testGetPlaceById() {
        Place mockPlace = new Place();
        mockPlace.setId(1L);

        when(placeRepository.findById(1L)).thenReturn(Optional.of(mockPlace));
        Place place = placeController.showById(mockPlace).getBody();
        assertThat(place.getId(), is(1L));
    }
}

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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
     * Test of index method, with returns all the Places
     * in the database.
     */
    @Test
    public void testGetAllPlaces() {
        // Mocks the all places list
        List<Place> mockPlaces = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Place place = new Place();
            place.setId(i);
            place.setName("Mock " + i);
            place.setSlug("mock-slug-" + i);
            mockPlaces.add(place);
        }
        when(placeRepository.findAll()).thenReturn(mockPlaces);
        Iterable<Place> places = placeController.index();

        // Checks if the list has some place in the mock
        assertThat(places, hasItem(mockPlaces.get(1)));
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

    /**
     * Test for creating a place
     */
    @Test
    public void testCreateAPlace() {
        // Place to send as request
        Place place = new Place();
        place.setName("Mock ");
        place.setSlug("mock-slug");

        // Mocks the response for saving the place
        Place savedPlaceMock = new Place();
        place.setId(1L);
        place.setName("Mock ");
        place.setSlug("mock-slug");
        LocalDateTime now = LocalDateTime.now();
        place.setCreatedAt(now);
        place.setUpdatedAt(now);

        when(placeRepository.save(place)).thenReturn(savedPlaceMock);

        Place savedPlace = placeController.create(place);
        assertThat(savedPlace, is(equalTo(savedPlaceMock)));
    }

}

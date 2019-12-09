package com.loompalandia.repository;

import com.loompalandia.dto.OompaloompaDto;
import com.loompalandia.dto.OompaloompaFullDto;
import com.loompalandia.entity.Oompaloompa;
import com.loompalandia.exceptions.OompaloompaNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

/**
 * Required repository for {@link Oompaloompa} objects.
 * @author Leandro Nardulli
 *
 */
public interface OompaloompaRepository {

	/**
	 * Searches the {@link Oompaloompa}
	 *
	 * @param pageable
	 *
	 * @return the {@link OompaloompaDto} list with Pageable parameters, if existings.
	 * @throws OompaloompaNotFoundException
	 *             ommpaloompa list is null or empty
	 */
	List<OompaloompaDto> list(Pageable pageable);

	/**
	 * Show full data of a OompaLoompa.
	 *
	 * @param id
	 *            unique Oompaloompa number id
	 * @return an oompaloompa's full data
	 */
	OompaloompaFullDto getFullDataById(Long id);

	/**
	 * Create a new OompaLoompa.
	 *
	 * @param oompaloompaFullDto
	 *            the {@link OompaloompaFullDto} to be saved
	 * @return the create instance
	 * @throws MethodArgumentNotValidException
	 *             ommpaloompa atributtes are not valid
	 */
	OompaloompaFullDto create(OompaloompaFullDto oompaloompaFullDto);

	/**
	 * Update a OompaLoompa.
	 *
	 * @param oompaloompaFullDto
	 *            the {@link OompaloompaFullDto} to be update
	 * @throws MethodArgumentNotValidException
	 *             ommpaloompa atributtes are not valid
	 */
	void update(Long id, OompaloompaFullDto oompaloompaFullDto);


}

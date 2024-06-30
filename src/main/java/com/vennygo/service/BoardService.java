package com.vennygo.service;

import com.vennygo.entity.Board;
import com.vennygo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Optional<Board> getBoard(long boardId) {
        return boardRepository.findById(boardId);
    }

    public List<Board> getBoards() {
        return boardRepository.findAllByIsDeleted(false);
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board updateBoard(Long boardId, Board boardDetail) {
        Board board = getBoard(boardId).orElseThrow(() -> new RuntimeException("not fount"));
        board.setTitle(boardDetail.getTitle());
        board.setContent(boardDetail.getContent());
        return boardRepository.save(board);
    }

    public Board deleteBoard(Long boardId) {
        Board board = getBoard(boardId).orElseThrow(() -> new RuntimeException("not fount"));
        board.setDeleted(true);
        return boardRepository.save(board);
    }
}

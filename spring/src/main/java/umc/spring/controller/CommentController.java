package umc.spring.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.CommentConverter.CommentConverter;
import umc.spring.converter.MarketConverter.MarketConverter;
import umc.spring.domain.Comment;
import umc.spring.domain.Market;
import umc.spring.dto.comment.CommentRequestDTO;
import umc.spring.dto.comment.CommentResponseDTO;
import umc.spring.dto.market.MarketRequestDTO;
import umc.spring.dto.market.MarketResponseDTO;
import umc.spring.service.CommentService.CommentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    // 가게에 리뷰 추가하기 API
    @PostMapping("")
    public ApiResponse<CommentResponseDTO.createResponseDTO> createComment(@RequestBody @Valid CommentRequestDTO.createDTO request){
        Comment comment = commentService.createComment_2(request); // 기존의 메서드명과 겹쳐서 임시로 2로 설정
        return ApiResponse.onSuccess(CommentConverter.toCreateResponseDTO(comment));
    }

}

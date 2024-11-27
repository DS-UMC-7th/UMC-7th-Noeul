package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
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
import umc.spring.validation.annotation.CheckPage;

import java.util.List;

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

    // 내가 작성한 리뷰 목록 API (페이징)
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API",description = "내가 작성한 리뷰를 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    // 계속 userId를 파라미터로 인식해서 주석처리
//    @Parameters({
//            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다! (토큰이 없어서 임시로 이걸로 받음)")
//    })
    @GetMapping("/{userId}")
    public ApiResponse<CommentResponseDTO.myCommentListDTO> myComment(
            @PathVariable("userId") Long userId,
            @RequestParam("page") @CheckPage int page
    ) {
        Page<Comment> comments = commentService.getMyCommentList(userId, page);
        return ApiResponse.onSuccess(CommentConverter.myCommentListDTO(comments));
    }


}

package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.service.CommentService.CommentQueryServiceImpl;
import umc.spring.service.MissionService.MissionQueryServiceImpl;
import umc.spring.service.MissionService.MissionService;
import umc.spring.service.UserService.UserQueryServiceImpl;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			// 내가 진행중, 진행 완료한 미션 모아서 보는 쿼리(페이징 포함)
			MissionQueryServiceImpl missionService = context.getBean(MissionQueryServiceImpl.class);

			String username = "eunseo";

			missionService.findUserMission(username, MissionStatus.INPROGRESS, 0, 5)
					.forEach(System.out::println);


			// 리뷰 작성하는 쿼리,
			//* 사진의 경우는 일단 배제
			CommentQueryServiceImpl commentService = context.getBean(CommentQueryServiceImpl.class);

			System.out.println(commentService.createComment(username, 1L, "너무좋아요", 4.5f));


			// 홈 화면 쿼리
			//(현재 선택 된 지역에서 도전이 가능한 미션 목록, 페이징 포함)
			Long regionId = 1L;
			missionService.findMissionByLocation(username, regionId, 0, 5)
					.forEach(System.out::println);

			// 마이 페이지 화면 쿼리
			UserQueryServiceImpl userService = context.getBean(UserQueryServiceImpl.class);

			System.out.println(userService.getUserInfo(username));

		};
	}
}




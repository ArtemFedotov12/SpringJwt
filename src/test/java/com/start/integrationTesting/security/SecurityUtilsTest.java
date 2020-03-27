package com.start.integrationTesting.security;

import static org.assertj.core.api.Assertions.assertThat;

public class SecurityUtilsTest {

/*   @Test
   public void getCurrentUsername() {
      SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
      securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("admin", "admin"));
      SecurityContextHolder.setContext(securityContext);

      Optional<String> username = SecurityUtils.getCurrentUsername();

      assertThat(username).contains("admin");
   }

   @Test
   public void getCurrentUsernameForNoAuthenticationInContext() {
      Optional<String> username = SecurityUtils.getCurrentUsername();

      assertThat(username).isEmpty();
   }*/
}

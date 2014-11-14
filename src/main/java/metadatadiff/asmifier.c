
#include <stdio.h>
#include <errno.h>
#include <unistd.h>
 
int main(int argc, char* argv[]) {
  int i;
  char* argv2[argc+3];
  argv2[0] = "java";
  argv2[1] = "-cp";
  argv2[2] = "/Users/amedina/workspace/live-code-updates/lcu-core/compiler/build/libs/asm-5.0.3/lib/all/asm-all-5.0.3.jar";
  argv2[3] = "org.objectweb.asm.util.ASMifier";
  for (i = 1;i < argc; i ++) {
    argv2[i+3] = argv[i];
  }
  argv2[argc+3] = 0;
  execvp("java", argv2);
  printf("Cannot execute '");
  for (i = 0;i < argc+2; i ++) { printf("%s ", argv2[i]); }
  printf("', caused by error: %d\n", errno);
}

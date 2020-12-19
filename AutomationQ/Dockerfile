FROM    maven:3.6.0-jdk-8
RUN     mkdir /AutomationQ
WORKDIR /AutomationQ
COPY    . .
RUN ls
CMD mvn clean test -DexecutionPlatform="GRID_CHROME"
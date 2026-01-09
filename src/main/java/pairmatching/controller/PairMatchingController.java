package pairmatching.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.model.crew.Course;
import pairmatching.model.crew.Crew;
import pairmatching.model.crew.Level;
import pairmatching.model.crew.Mission;
import pairmatching.model.pair.Pair;
import pairmatching.model.pair.PairResult;
import pairmatching.model.pair.PairResults;
import pairmatching.util.ErrorMessage;
import pairmatching.util.FileScanner;
import pairmatching.view.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    FileScanner fileScanner = new FileScanner();

    public void run() {
        PairResults pairResults = new PairResults();
        while (true) {
            try {
                String menuNumber = InputView.readMenu();
                if (menuNumber.equals("Q")) {
                    break;
                }
                InputValidator.validateEmpty(menuNumber);
                InputValidator.validateNumeric(menuNumber);
                handlerMenu(menuNumber, pairResults);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void handlerMenu(String menuNumber, PairResults pairResults) {
        if (menuNumber.equals("1")) {
            makePair(pairResults);
        }
        if (menuNumber.equals("2")) {
            searchInfo(pairResults);
        }
        if (menuNumber.equals("3")) {
            pairResults.clearList();
        }
    }

    private void makePair(PairResults pairResults) {
        boolean ok = false;
        int count = 0;
        do {
            count++;
            String input = InputView.readInfo();
            List<String> inputList = Arrays.asList(input.split(","));
            Course course = Course.getCourse(inputList.get(0).trim());
            Level level = Level.getLevel(inputList.get(1).trim());
            Mission mission = Mission.getMission(level, inputList.get(2).trim());
            PairResult periodResult = pairResults.findByInfo(course, level, mission);

            List<String> crewNames = chooseCourse(course);

            PairResult pairResult = shuffledCrew(crewNames, course, level, mission);

            if (periodResult == null || !checkDuplicate(periodResult.getPairList(), pairResult.getPairList())) {
                ok = true;
                pairResults.addList(pairResult);
                OutputView.printList(pairResult.getPairList());
                break;
            }

            if (count == 3) {
                throw new IllegalArgumentException(ErrorMessage.MATCHING_FAIL.getMessage());
            }
        } while (ok && count < 3);
    }

    private boolean checkDuplicate(List<Pair> periodResult, List<Pair> newResult) {
        return periodResult.stream().anyMatch(newResult::contains);
    }

    private List<String> chooseCourse(Course course) {
        List<Crew> backendCrews = fileScanner.loadBackendCrews();
        List<Crew> frontendCrews = fileScanner.loadFrontendCrews();
        if (course == Course.BACKEND) {
            return backendCrews.stream()
                    .map(Crew::getName)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return frontendCrews.stream()
                .map(Crew::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private PairResult shuffledCrew(List<String> crewNames, Course course, Level level, Mission mission) {
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        PairResult pairResult = new PairResult(course, level, mission);
        for (int i = 0; i < shuffledCrew.size(); i += 2) {
            Pair pair = new Pair();
            pair.add(shuffledCrew.get(i));
            pair.add(shuffledCrew.get(i+1));
            if (i == shuffledCrew.size() - 3) {
                pair.add(shuffledCrew.get(i+2));
                i++;
            }
            pairResult.addPairResult(pair);
        }
        return pairResult;
    }

    private void searchInfo(PairResults pairResults) {
        String input = InputView.readInfo();
        List<String> inputList = Arrays.asList(input.split(","));
        Course course = Course.getCourse(inputList.get(0).trim());
        Level level = Level.getLevel(inputList.get(1).trim());
        Mission mission = Mission.getMission(level, inputList.get(2).trim());
        PairResult pairResult = pairResults.findByInfo(course, level, mission);
        validateHistory(pairResult);

        OutputView.printList(pairResult.getPairList());
    }

    private void validateHistory(PairResult pairResult) {
        if (pairResult == null) {
            throw new IllegalArgumentException(ErrorMessage.NON_MATCHING_HISTORY.getMessage());
        }
    }
}

package easytests.options;

import easytests.models.IssueStandardTopicPriorityModelInterface;
import easytests.services.IssueStandardTopicPrioritiesServiceInterface;
import easytests.services.IssueStandardsServiceInterface;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Setter;

/**
 * @author SingularityA
 */
@EqualsAndHashCode
public class IssueStandardTopicPrioritiesOptions implements IssueStandardTopicPrioritiesOptionsInterface {

    @Setter
    private IssueStandardTopicPrioritiesServiceInterface topicPrioritiesService;

    @Setter
    private IssueStandardsServiceInterface issueStandardsService;

    private IssueStandardsOptionsInterface issueStandardsOptions;

    @Override
    public IssueStandardTopicPrioritiesOptionsInterface
        withIssueStandard(IssueStandardsOptionsInterface issueStandardsOptions) {
        this.issueStandardsOptions = issueStandardsOptions;
        return this;
    }

    @Override
    public IssueStandardTopicPriorityModelInterface
        withRelations(IssueStandardTopicPriorityModelInterface topicPriorityModel) {

        if (topicPriorityModel == null) {
            return topicPriorityModel;
        }
        if (this.issueStandardsOptions != null) {
            topicPriorityModel.setIssueStandard(this.issueStandardsService
                    .find(topicPriorityModel.getIssueStandard().getId(), this.issueStandardsOptions));
        }
        return topicPriorityModel;
    }

    @Override
    public List<IssueStandardTopicPriorityModelInterface>
        withRelations(List<IssueStandardTopicPriorityModelInterface> topicPriorityModels) {

        for (IssueStandardTopicPriorityModelInterface topicPriorityModel: topicPriorityModels) {
            this.withRelations(topicPriorityModel);
        }
        return topicPriorityModels;
    }

    @Override
    public void saveWithRelations(IssueStandardTopicPriorityModelInterface topicPriorityModel) {
        if (this.issueStandardsOptions != null) {
            this.issueStandardsService.save(topicPriorityModel.getIssueStandard(), this.issueStandardsOptions);
        }
        this.topicPrioritiesService.save(topicPriorityModel);
    }

    @Override
    public void deleteWithRelations(IssueStandardTopicPriorityModelInterface topicPriorityModel) {
        this.topicPrioritiesService.delete(topicPriorityModel);
        if (this.issueStandardsOptions != null) {
            this.issueStandardsService.delete(topicPriorityModel.getIssueStandard(), this.issueStandardsOptions);
        }
    }
}
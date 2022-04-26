# CaseStudy

Project consists of two modules;

- App
- Assignment

App module contains launcher activity with two activities for testing purposes.

Assignment module containts custom view along with the metric service alongside with it.

## Assignment

### Design Principle 

AssignmentView is a custom ConstraintLayout with RecyclerView in it. The first reason I went for the ConstraintLayout instead of ViewPager2 is 
scalability and customization. You can easily add new views to the custom view to interact with the RecyclerView (i.e, page indicator at the top). Second reason
is ViewPager2 uses fragments with RecyclerView internally, so it's slower compared to RecyclerView with plain old ViewHolder.

### Image Loading

Coil handles all image loading along with both memory and disk caching, cache keys based on URL's. 

### Metrics

MetricManager has a Flow that listens for image loading times with success or error state and UUID for each and every image loading operation. After 
gathering enough data, it sends these data to API service. You could also send every time a metric collected but that would use network 
resources unnecessarily. Though you can change this logic with relative ease.

### Testing

Custom attribution for automatic skipping is available for AutomaticScrollingActivity. You can observe metric system this way without any input, starting 
AutomaticScrollingActivity should be enough. 

ManualScrollingActivity as the name states will need user swipe to snap next or previous items.


Thank you, it was fun.




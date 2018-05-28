#include <vector>

#include "test_framework/fmt_print.h"
#include "test_framework/generic_test.h"
#include "test_framework/test_utils_serialization_traits.h"

using std::vector;

struct HighwaySection {
  int x, y, distance;
};

HighwaySection FindBestProposals(const vector<HighwaySection>& H,
                                 const vector<HighwaySection>& P, int n) {
  // Implement this placeholder.
  return {0, 0, 0};
}

template <>
struct SerializationTraits<HighwaySection>
    : UserSerTraits<HighwaySection, int, int, int> {};

bool operator==(const HighwaySection& lhs, const HighwaySection& rhs) {
  return lhs.x == rhs.x && lhs.y == rhs.y && lhs.distance == rhs.distance;
}

std::ostream& operator<<(std::ostream& out, const HighwaySection& hs) {
  return PrintTo(out, std::make_tuple(hs.x, hs.y, hs.distance));
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"H", "P", "n"};
  return GenericTestMain(args, "road_network.tsv", &FindBestProposals,
                         DefaultComparator{}, param_names);
}